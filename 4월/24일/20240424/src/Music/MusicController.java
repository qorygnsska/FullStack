package Music;

import java.util.ArrayList;

public class MusicController {
	ArrayList<Music> list = new ArrayList<Music>();
	ArrayList<Music> slist = new ArrayList<Music>();
	
	public int addList(Music music) {
		list.add(music);
		return 1;
	}
	
	public int addAtZero(Music music) {
		list.add(0, music);
		return 1;
	}
	
	public ArrayList<Music> printAll() {
		
		return list;
	}
	
	public Music searchMusic(String title) {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getTitle().equals(title)) {
				return list.get(i);
			} 
		}
		return null;
	}
	
	public Music removeMusic(String title) {
		
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getTitle().equals(title)) {
				slist.add(0, list.get(i));
				list.remove(i);
				return slist.get(0);
			} 
		}
		return null;
	}
	
	public Music setMusic(String title, Music music) {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getTitle().equals(title)) {
				slist.add(0, new Music(list.get(i).getTitle(),list.get(i).getSinger()));
				list.get(i).setTitle(music.getTitle());
				list.get(i).setSinger(music.getSinger());
				return slist.get(0);
			}
		}
		return null;
	}
	
}
