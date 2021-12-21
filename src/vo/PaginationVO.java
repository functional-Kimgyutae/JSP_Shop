package vo;

public class PaginationVO {
	private int perPage = 5;
	private int art = 9; 
	private boolean next = true; 
	private boolean prev = true;
	private int start = 1;
	private int end = 5;
	private int totalPage; 
	private int total; 
	

	public void construct(int total,int page) {
		this.total = total;
		totalPage = Math.floorDiv(total,art)+1;
		end = (int)((Math.ceil((float)page/perPage)) * perPage);
		start = end - perPage+1;
		if(end >= totalPage) {
			end = totalPage;
			next = false;
		}
		if(start <= 1) {
			start = 1;
			prev = false;
		}
	}
	public int getTotal() {
		return total;
	}
	
	public int getPerPage() {
		return perPage;
	}

	public int getArt() {
		return art;
	}

	public boolean isNext() {
		return next;
	}

	public boolean isPrev() {
		return prev;
	}

	public int getStart() {
		return start;
	}

	public int getEnd() {
		return end;
	}

	public int getTotalPage() {
		return totalPage;
	}
}
