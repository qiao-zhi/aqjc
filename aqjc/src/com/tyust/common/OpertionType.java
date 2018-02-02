package com.tyust.common;

import java.util.EnumMap;

public class OpertionType {
	public enum State {
		ADD, DELETE, LOGIN, LOGOUT, UPDATE
	}

	public static String OpertionEnum(OpertionType.State state) {
		EnumMap<State, String> opertionMap = new EnumMap<State, String>(State.class);
		opertionMap.put(State.ADD, "添加");
		opertionMap.put(State.DELETE, "删除");
		opertionMap.put(State.LOGIN, "登录");
		opertionMap.put(State.LOGOUT, "退出");
		opertionMap.put(State.UPDATE, "修改");
		return opertionMap.get(state).toString();
	}
}
