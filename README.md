Run the app using shared idea run configuration.

Access the servlet at `<server:port>/app/shop` path

Or simply run
`mvn jetty:run` and you can access your servlets.

To generate effective web xml using jetty maven plugin, run
`mvn jetty:effective-web-xml` and this shall generate web.xml in target directory.

To run non http servlets, use tomcat plugin.
`mvn tomcat7:run`
