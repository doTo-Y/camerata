#Github第三方登录

#H2连接密码错误
create user if not exists 用户名 password '密码;
alter user 用户名 admin true;

#flyway更新migration
mvn flyway:migrate

文档
[Spring 文档](https://spring.io/guides)    
[Spring Web](https://spring.io/guides/gs/serving-web-content/) 
[Bootstrap](https://v3.bootcss.com/getting-started/)
[Github OAuth](https://developer.github.com/apps/building-oauth-apps/authorizing-oauth-apps/)
[OkHttp官方文档](https://square.github.io/okhttp/)