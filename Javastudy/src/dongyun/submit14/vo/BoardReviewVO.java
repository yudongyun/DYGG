package dongyun.submit14.vo;

public class BoardReviewVO {
    private int brNumber;
    private int fbNumber;
    private String brContent;
    private String brAuthor;
    private String brDate;
    
    public BoardReviewVO(int brNumber, int fbNumber, String brContent, String brAuthor, String brDate) {
        this.brNumber = brNumber;
        this.fbNumber = fbNumber;
        this.brContent = brContent;
        this.brAuthor = brAuthor;
        this.brDate = brDate;
    }

    
    
	@Override
	public String toString() {
		return "BoardReviewVO [brNumber=" + brNumber + ", fbNumber=" + fbNumber + ", brContent=" + brContent
				+ ", brAuthor=" + brAuthor + ", brDate=" + brDate + "]";
	}

	public int getBrNumber() {
		return brNumber;
	}

	public void setBrNumber(int brNumber) {
		this.brNumber = brNumber;
	}

	public int getFbNumber() {
		return fbNumber;
	}

	public void setFbNumber(int fbNumber) {
		this.fbNumber = fbNumber;
	}

	public String getBrContent() {
		return brContent;
	}

	public void setBrContent(String brContent) {
		this.brContent = brContent;
	}

	public String getBrAuthor() {
		return brAuthor;
	}

	public void setBrAuthor(String brAuthor) {
		this.brAuthor = brAuthor;
	}

	public String getBrDate() {
		return brDate;
	}

	public void setBrDate(String brDate) {
		this.brDate = brDate;
	}
    
    
}
