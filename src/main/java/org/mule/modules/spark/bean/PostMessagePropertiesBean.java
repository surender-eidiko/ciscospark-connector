package org.mule.modules.spark.bean;


// TODO: Auto-generated Javadoc
/**
 * The Class PostMessagePropertiesBean.
 */
public class PostMessagePropertiesBean  {
	
	/** The room id. */
	private String roomId;
	
	/** The to person id. */
	private String toPersonId;
	
	/** The to person email. */
	private String toPersonEmail;
	
	/** The text. */
	private String text;
	
	/** The markdown. */
	private String markdown;
	
	/** The files. */
	private String[] files;
	
	/** The html. */
	private String html;
	
	

	/**
	 * Gets the html.
	 *
	 * @return the html
	 */
	public String getHtml() {
		return html;
	}

	/**
	 * Sets the html.
	 *
	 * @param html the new html
	 */
	public void setHtml(String html) {
		this.html = html;
	}

	/**
	 * Gets the room id.
	 *
	 * @return the room id
	 */
	public String getRoomId() {
		return roomId;
	}

	/**
	 * Sets the room id.
	 *
	 * @param roomId the new room id
	 */
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	/**
	 * Gets the to person id.
	 *
	 * @return the to person id
	 */
	public String getToPersonId() {
		return toPersonId;
	}

	/**
	 * Sets the to person id.
	 *
	 * @param toPersonId the new to person id
	 */
	public void setToPersonId(String toPersonId) {
		this.toPersonId = toPersonId;
	}

	/**
	 * Gets the to person email.
	 *
	 * @return the to person email
	 */
	public String getToPersonEmail() {
		return toPersonEmail;
	}

	/**
	 * Sets the to person email.
	 *
	 * @param toPersonEmail the new to person email
	 */
	public void setToPersonEmail(String toPersonEmail) {
		this.toPersonEmail = toPersonEmail;
	}

	/**
	 * Gets the text.
	 *
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Sets the text.
	 *
	 * @param text the new text
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * Gets the markdown.
	 *
	 * @return the markdown
	 */
	public String getMarkdown() {
		return markdown;
	}

	/**
	 * Sets the markdown.
	 *
	 * @param markdown the new markdown
	 */
	public void setMarkdown(String markdown) {
		this.markdown = markdown;
	}

	/**
	 * Gets the files.
	 *
	 * @return the files
	 */
	public String[] getFiles() {
		return files;
	}

	/**
	 * Sets the files.
	 *
	 * @param files the new files
	 */
	public void setFiles(String[] files) {
		this.files = files;
	}

}
