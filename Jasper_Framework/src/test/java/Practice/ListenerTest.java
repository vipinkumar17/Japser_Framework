package Practice;

import org.junit.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;
@Listeners(com.crm.vtiger.GenericUtils.ListenerImplimentation.class)
public class ListenerTest extends BaseClass
{
	@Test
	public void login()
	{
		Assert.fail();
	}
}
