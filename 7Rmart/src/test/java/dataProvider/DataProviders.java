package dataProvider;

import org.testng.annotations.DataProvider;

public class DataProviders {
	@DataProvider(name="InvalidUserCredentials")
	public Object[][] verifyUserCredentialsData()
	{
		Object data[][]=new Object[3][2];
		
		data[0][0]="342";
		data[0][1]="admin";
		
		data[1][0]="admin";
		data[1][1]="truy";
		
		data[2][0]="dfs";
		data[2][1]="546";
		
		return data;
	}

}
