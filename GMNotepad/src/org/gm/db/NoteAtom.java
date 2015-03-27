package org.gm.db;


public class NoteAtom {
	public int id;
	public long updatedTimestamp;
	public long createdTimestamp;
	public String title;
	public String content;
	public String imageUrls;
	public String mediaUrls;


	public NoteAtom(String title, String content, String imageUrls, String mediaUrls) {
		this.createdTimestamp = System.currentTimeMillis() / 1000;
		this.updatedTimestamp = this.createdTimestamp;
		this.title = title;
		this.content = content;
		this.imageUrls = imageUrls;
		this.mediaUrls = mediaUrls;
	}

	public NoteAtom(String title, String content, String imageUrls,
			String mediaUrls, int createdTimestamp, int updatedTimestamp) {
		this.title = title;
		this.content = content;
		this.imageUrls = imageUrls;
		this.mediaUrls = mediaUrls;
		this.createdTimestamp = createdTimestamp;
		this.updatedTimestamp = updatedTimestamp;
	}

	
	public NoteAtom(int id, String title, String content, String imageUrls,
			String mediaUrls, long createdTimestamp, long updatedTimestamp) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.imageUrls = imageUrls;
		this.mediaUrls = mediaUrls;
		this.createdTimestamp = createdTimestamp;
		this.updatedTimestamp = updatedTimestamp;
	}
}
