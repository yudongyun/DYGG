package dongyun.submit12;

public class AudioBoard extends Board{

	
	private String odi;
	
	private AudioBoard() {}

	
	public AudioBoard(int num, String title, String date, String content) {
		super(num, title, date, content);
	}

	@Override
	public String toString() {
		return "AudioBoard [odi=" + odi + "]";
	}

	public String getOdi() {
		return odi;
	}

	public void setOdi(String odi) {
		this.odi = odi;
	}
	
	
	
	
	
	
}
