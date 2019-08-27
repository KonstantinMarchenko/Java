This is Advertiser app created by Marchenko Konstantin
To run application from command line type in: java -jar \Pass for Advertiser folder\build\libs\Advertiser.jar
To access swagger in your browser go to: http://localhost:8080/swagger-ui.html
To access h2 database in your browser go to: http://localhost:8080/h2-console
	to connect to database: Driver: org.h2.Driver
				JDBC: jdbc:h2:mem:test_mem
				Username: sa
				Password: empty
	the advertiser table will create automatically on the first interogation with the base (you can call any request in swagger)
To access endpoints in your browser go to: http://localhost:8080/endpoints
	available endpoints: health, info