
public class Test {

	public static void main(String[] args) {
		int cntPerPage = 10;
		int totalPage = 10;
		//int cntPerPageGroup=3;
		int cntPerPageGroup=4;
		
		for(int currentPage=1; currentPage<=10; currentPage++) {
			int startPage = ((currentPage-1)/cntPerPageGroup)*cntPerPageGroup+1;
			int endPage = startPage + cntPerPageGroup -1;
			if(endPage > totalPage ) {
				endPage = totalPage;
			}
			System.out.println("current:" + currentPage + ", startPage:" + startPage+", endPage:" + endPage);
		}
	}

}
