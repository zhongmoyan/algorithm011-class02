# 关于 HashMap 的小总结

先要做一个说明，这次分析的 HashMap 是基于 jdk1.8 的版本。

## HashMap 内部实现基本点分析。

### Node数组+单向链表+红黑树的结构

数组被分为一个个桶（bucket），通过哈希值决定了键值对在这个数组的寻址；哈希值相同的键值对，则以链表形式存储。如果链表大小超过阈值（TREEIFY_THRESHOLD, 8），链表就会被改造为树形结构。

> ```java
> if ((e = p.next) == null) {
>     p.next = newNode(hash, key, value, null);
>     if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
>         treeifyBin(tab, hash);
>     break;
> }
> ```

树化改造

> ```java
> final void treeifyBin(Node<K,V>[] tab, int hash) {
>     int n, index; Node<K,V> e;
>     if (tab == null || (n = tab.length) < MIN_TREEIFY_CAPACITY)
>         resize();
>     else if ((e = tab[index = (n - 1) & hash]) != null) {
>         TreeNode<K,V> hd = null, tl = null;
>         ... //树化逻辑改造
>     }
> }
> ```

如果容量小于 （MIN_TREEIFY_CAPACITY, 64），只会进行简单的扩容。
如果容量大于 （MIN_TREEIFY_CAPACITY, 64），则会进行树化改造。

构造函数

> ```java
> public HashMap() {
>     this.loadFactor = DEFAULT_LOAD_FACTOR; // all other fields defaulted
> }
> ```

按照 lazy-load 原则，初始化的时候仅仅只是设置了一些初始值，Node数组并没有进行初始化。

### put ()

> ```java
> public V put(K key, V value) {
>     return putVal(hash(key), key, value, false, true);
>     //hash(key) 计算 hash 值
> }
> 
> static final int hash(Object key) {
>     int h;
>     return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
>     //高低位的划分，将高位数据移位到低位进行异或运算，使得不需要在每次扩容的时候来重新计算 hash
> }
> ```

> ```JAVA
>     final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
>                    boolean evict) {
>         ...
>         
>         if ((p = tab[i = (n - 1) & hash]) == null)
>             tab[i] = newNode(hash, key, value, null);//找不到，直接封装成 node 插入
>         else {
>             Node<K,V> e; K k;
>             if (p.hash == hash &&
>                 ((k = p.key) == key || (key != null && key.equals(k))))
>                 e = p;
>             else if (p instanceof TreeNode)
>                 e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
>             else {
>                 for (int binCount = 0; ; ++binCount) {
>                     if ((e = p.next) == null) {
>                         p.next = newNode(hash, key, value, null);
>                         if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
>                             treeifyBin(tab, hash);
>                         break;
>                     }
>                     if (e.hash == hash &&
>                         ((k = e.key) == key || (key != null && key.equals(k))))
>                         break;
>                     p = e;
>                 }
>             }
>             if (e != null) { // existing mapping for key
>                 ...
>             }
>         }
>         ++modCount;
>         if (++size > threshold)
>             resize();
>         afterNodeInsertion(evict);
>         return null;
>     }
> ```

put操作的流程：
①.key.hash()，时间复杂度O(1)；
②.根据hash值得到Node数组，如果table[i]==null，直接新建节点添加，时间复杂度O(1)；
③.判断table[i]的首个元素是否和key一样，如果相同走“existing mapping for key”,时间复杂度O(1)；
④.判断table[i] 是否为treeNode，即table[i] 是否是红黑树，如果是红黑树，则直接在树中插入键值对,时间复杂度O(logn)；
⑤.遍历table[i]，判断链表长度是否大于8，大于8的话把链表转换为红黑树，在红黑树中执行插入操作，否则进行链表的插入操作,时间复杂度O(n)；

HashMap新增元素的时间复杂度是不固定的，可能的值有O(1)、O(logn)、O(n)。

### get()

同put()差不多。