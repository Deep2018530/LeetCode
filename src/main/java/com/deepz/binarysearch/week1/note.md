

### TASK

* 69
* 35
* 34
* 74
* 153
* 33
* 278
* 162
* 287
* 275

### 参考解析资料

[LeetCode暑期刷题打卡2019——Week1 二分专题](https://www.bilibili.com/video/av59202632)


```java

public int bsearch(int l,int r){

        while(l < r){
            int mid = l + r >> 1;
            if(check(mid)){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return l;
}  
    
public int bsearch(int l, int r) {
    
        while (l < r) {
             int mid = l + r + 1 >> 1;
             if (check(mid)) {
                  l = mid;
             } else {
                  r = mid - 1;
             }
         }
         return l;
}
    
```

> 二分的流程：

1. 确定二分的边界
2. 编写二分的代码框架
3. 设计一个check(性质)
4. 判断一下区间如何更新
5. 如果更新方式写的是l = mid,r = mid-1,那么就在算mid的时候+1