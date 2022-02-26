import architecture.diagram_intra_process

diagram_intra_process {
    layer("应用层", "#HotPink") {
        component("Activity").call("ViewModel", "方法调用")
        component("ViewModel").call("Presenter", "方法调用")
        component("Service").call("Presenter", "方法调用")
    }

    layer("业务层", "#orange") {
        component("Presenter").call("Repository", "方法调用")
    }

    layer("数据层", "#LightSeaGreen") {
        val repo = component("Repository")
        repo.call("DBDataSource", "方法调用")
        repo.call("RemoteDataSource", "方法调用")
        // DBDataSource组件会调用系统的DB来读写数据
        component("DBDataSource").call("SqliteDB", "读写")
        // RemoteDataSource组件会调用进程外的BFF来获取数据
        component("RemoteDataSource").call("MobileBFF", "Http请求")
    }

    // 进程外的push服务会调用进程内的service来推送消息
    process("PushService").call("Service", "消息推送")
    // 进程外的BFF服务
    process("MobileBFF")
    // 进程外的系统数据库
    process("SqliteDB")

} export "./diagrams/intra_process_diagram.png"
