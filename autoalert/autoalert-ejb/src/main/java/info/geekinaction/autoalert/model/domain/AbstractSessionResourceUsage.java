/**
 * 
 */
package info.geekinaction.autoalert.model.domain;


/**
 * @author lcsontos
 *
 */
public abstract class AbstractSessionResourceUsage extends AbstractSession {

	private static final long serialVersionUID = 1L;
	
	protected Long value;
	
	/**
	 * 
	 * @return
	 */
	public Long getValue() {
		return value;
	}
	
	/**
	 * 
	 * @param value
	 */
	public void setValue(Long value) {
		this.value = value;
	}

}