package pojo;
/**
 * 朋友信息
 * @author Administrator
 *
 */
public class FriendInfo {
    private int FriendId;   
    private String FriendName;
    private String mood;    //个性签名
	public int getFriendId() {
		return FriendId;
	}
	public void setFriendId(int friendId) {
		FriendId = friendId;
	}
	public String getFriendName() {
		return FriendName;
	}
	public void setFriendName(String friendName) {
		FriendName = friendName;
	}
	public String getMood() {
		return mood;
	}
	public void setMood(String mood) {
		this.mood = mood;
	}
	@Override
	public String toString() {
		return "FriendInfo [FriendId=" + FriendId + ", FriendName="
				+ FriendName + ", mood=" + mood + "]";
	}
    
}
