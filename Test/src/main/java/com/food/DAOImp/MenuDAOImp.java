package com.food.DAOImp;

public class MenuDAOImp {

	void getMenuByRestId(int restaurantId)
	{
		String sql = "select * from menu where restaurantId = ?";
	}
}
