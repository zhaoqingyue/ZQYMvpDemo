### MVP架构设计

**1. MVP层次划分**

- Model：实体层，负责业务逻辑处理（网络数据请求、数据库读取等）
- View：视图层，负责界面展示（Activitiy 、Fragment & View）
- Presenter：逻辑控制层，持有 View & Model 的引用，解耦 View & Model

MVP三者关系图：

![image](https://github.com/zhaoqingyue/ZQYMvpDemo/blob/master/img/mvp.png)

**2. 基本流程**

- 进入Activity（Activity 作为 View层 ）
- View层通知 Presenter 加载数据
- Presenter 调用 Model 加载数据
- Model层加载完后，回调给 Presenter
- Presenter 通知 View 更新界面

**3. 编写方式**

- View层：编写 XXView 接口，对应的 Activity & Fragment 实现该接口
- Model层：网络数据请求 & 其它耗时操作，用 Presenter 层定义的接口，回调给 Presenter，并通知 View 层更新数据
- Presenter层：持有 View层 & Model层的引用，并且实现 Presenter 层定义的回调接口。在回调接口中调用 View层的代码进行界面更新；调用 Model 层请求数据
- 回到View层的Activity ，调用 Presenter层获取数据
