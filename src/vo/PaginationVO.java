package vo;

public class PaginationVO {
	public int perPage = 5; // 페이지네이션 개수
	public int art = 9; // 한 페이지당 나오는 갯수
	public boolean next = true; //다음페이지가 누르는게가능한가
	public boolean prev = true;
	public int start = 1;
	public int end = 5;
	public int totalPage; //페이지 갯수
	public int total; // 상품 총 갯수
	

	public void construct(int total,int page) { // total : 총 cnt , page : 현재 페이지
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
