package VO;

public class LastVoteInfoVO {
	
		private String img_name;			
		private String img;
		private String title;
		private int like;
		private int dislike;
		private String win;
		
		public LastVoteInfoVO(String img_name, String img, String title, int like, int dislike, String win) {
			//super();
			this.img_name = img_name;
			this.img = img;
			this.title = title;
			this.like = like;
			this.dislike = dislike;
			this.win = win;
		}
		

		public String getImg() {
			return img;
		}

		public String getImg_name() {
			return img_name;
		}


		public void setImg_name(String img_name) {
			this.img_name = img_name;
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

		public int getLike() {
			return like;
		}

		public void setLike(int like) {
			this.like = like;
		}

		public int getDislike() {
			return dislike;
		}

		public void setDislike(int dislike) {
			this.dislike = dislike;
		}

		public String getWin() {
			return win;
		}

		public void setWin(String win) {
			this.win = win;
		}

		public LastVoteInfoVO() { }
		
		
	}			

