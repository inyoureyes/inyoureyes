package pojo;

public class RelationShip {
	/**
	 * +-----------+---------+------+-----+---------+----------------+
| Field     | Type    | Null | Key | Default | Extra          |
+-----------+---------+------+-----+---------+----------------+
| id        | int(10) | NO   | PRI | NULL    | auto_increment |
| user_id   | int(10) | YES  | MUL | NULL    |                |
| friend_id | int(10) | YES  |     | NULL    |                |
| status    | int(5)  | YES  |     | 0       |                |
+-----------+---------+------+-----+---------+----------------+
	 */
	private int id;
	private int user_id;
	private int friend_id;
	private int status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getFriend_id() {
		return friend_id;
	}
	public void setFriend_id(int friend_id) {
		this.friend_id = friend_id;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "RelationShip [id=" + id + ", user_id=" + user_id
				+ ", friend_id=" + friend_id + ", status=" + status + "]";
	}

}
