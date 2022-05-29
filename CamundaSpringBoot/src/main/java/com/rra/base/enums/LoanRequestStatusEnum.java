package com.rra.base.enums;

public enum LoanRequestStatusEnum {

	Active(2, "active"),
	Denied(3, "denied"),
	Processed(4, "processed"),
	UNKNOWN(LoanRequestStatusEnum.Unknown, "unknown");

	private static final int Unknown = 1;
	private String name;
	private int id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	LoanRequestStatusEnum(int id, String name) {
		this.name = name;
		this.id = id;
	}

	public static LoanRequestStatusEnum get(int id) {
		LoanRequestStatusEnum types[] = LoanRequestStatusEnum.values();
		for (LoanRequestStatusEnum type : types) {
			int i = type.getId();
			if (i == id) {
				return type;
			}
		}

		return LoanRequestStatusEnum.UNKNOWN;
	}

	public static LoanRequestStatusEnum get(String name) {
		LoanRequestStatusEnum types[] = LoanRequestStatusEnum.values();
		for (LoanRequestStatusEnum type : types) {
			String n = type.getName();
			if (n.equals(name)) {
				return type;
			}
		}
		return LoanRequestStatusEnum.UNKNOWN;
	}
}
