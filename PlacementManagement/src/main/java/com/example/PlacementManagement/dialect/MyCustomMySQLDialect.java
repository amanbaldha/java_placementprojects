package com.example.PlacementManagement.dialect;
import org.hibernate.dialect.MySQL8Dialect;

@SuppressWarnings("deprecation")
public class MyCustomMySQLDialect extends MySQL8Dialect{
	public MyCustomMySQLDialect() {
        super();
    }
}
