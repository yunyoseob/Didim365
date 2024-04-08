package com.day5_jdbc_coding;

public class TESTVO {
	private String id;
	private String name;
	private String insertdate;
	private String updatedate;
	private String deleteyn;
	
	public TESTVO(){
		
	};
	
	public TESTVO(String id, String name, String insertdate, String updatedate, String deleteyn) {
		this.id = id;
		this.name = name;
		this.insertdate = insertdate;
		this.updatedate = updatedate;
		this.deleteyn = deleteyn;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getInsertdate() {
		return insertdate;
	}

	public String getUpdatedate() {
		return updatedate;
	}

	public String getDeleteyn() {
		return deleteyn;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setInsertdate(String insertdate) {
		this.insertdate = insertdate;
	}

	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}

	public void setDeleteyn(String deleteyn) {
		this.deleteyn = deleteyn;
	}
	
	// print
	public static void printTESTVO(TESTVO tvo){
		System.out.print(tvo.getId()+" : ");
		System.out.print(tvo.getName()+" : ");
		System.out.print(tvo.getInsertdate()+" : ");
		System.out.print(tvo.getUpdatedate()+" : ");
		System.out.print(tvo.getDeleteyn()+" : ");
		System.out.println();
	}
}
