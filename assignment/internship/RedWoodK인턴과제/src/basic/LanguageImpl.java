package basic;

public class LanguageImpl implements Language {

	@Override
	public void korea() {
		System.out.println("�ȳ��ϼ���.");
	}

	@Override
	public void japan() {
		System.out.println("�����̿�");
	}

	@Override
	public void china() {
		System.out.println("���Ͽ�");
	}

	@Override
	public void america() {
		System.out.println("���");
	}

}
