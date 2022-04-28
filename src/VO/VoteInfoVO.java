package VO;

public class VoteInfoVO {

	private String img_name;			
	private String img;
	private String title;

	
	public VoteInfoVO(String img_name, String img, String title) {
		//super();
		this.img_name = img_name;
		this.img = img;
		this.title = title;
	}
	
	public VoteInfoVO() { }

	

	public String getImg_name() {
		return img_name;
	}

	public void setImg_name(String img_name) {
		this.img_name = img_name;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	

	


}
