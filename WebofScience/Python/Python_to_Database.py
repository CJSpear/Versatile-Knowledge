
import jaydebeapi

connection  = jaydebeapi.connect(
        "org.h2.Driver",
        "jdbc:h2:tcp://localhost/~/test",
        ["sa", ""],
        "/home/caleb/Desktop/h2/h2-latest.jar")
cursor = connection.cursor()
cursor.execute('create table WORK'
                '("CUST_ID" INTEGER not null,' ' "NAME" VARCHAR(50) not null,'
                ' primary key ("CUST_ID"))'
                )
cursor.execute("insert into WORK values (1, 'John')")
cursor.execute("select * from WORK")
cursor.fetchall()
cursor.close()
connection.close()
