package basic;

public class LanguageImpl implements Language {

	@Override
	public void korea() {
		System.out.println("안녕하세요.");
	}

	@Override
	public void japan() {
		System.out.println("오하이요");
	}

	@Override
	public void china() {
		System.out.println("니하오");
	}

	@Override
	public void america() {
		System.out.println("헬로");
	}

}
