# gulischool
谷粒学院的前后端代码

启动过程(以windows为例)：

* 首先启动nacos（单机启动）：startup.cmd -m standalone

* 然后启动redis：redis-server.exe
* 再启动nginx服务：nginx.exe
* 为了展示页面，可以启动:ServiceAclApplication和ApiGatewayApplication这俩个微服务
* 启动前端(前台和后台的启动命令一样)页面npm run dev
