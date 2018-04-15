package com.study.pattern.vm.constant;

public enum Recommendation {

	MANADATORY(1), RECOMMENDED(2), NORMAL(3), BLOCKED(98), OK(99);

	private int priority;

	private Recommendation(int priority) {
		this.priority = priority;
	}

	public int getPriority() {
		return priority;
	}

}
