import java.util.*;
import java.io.*;

class Solution {
    
    class Music implements Comparable<Music> {
        int play;
        int musicNum;
        
        Music(int play, int musicNum) {
            this.play = play;
            this.musicNum = musicNum;
        }
        
        @Override
        public int compareTo(Music o1) {
            return o1.play - this.play;
        }
    }
    
    class Genre {
        String name;
        int totalNum;
        List<Music> list = new ArrayList<>();
        
        Genre(String name, int totalNum) {
            this.totalNum = totalNum;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        
        Map<String, Genre> map = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++) {
            
            if(map.containsKey(genres[i])){
                Genre genre = map.get(genres[i]);
                genre.totalNum+=plays[i];
                genre.list.add(new Music(plays[i],i));
                map.put(genres[i], genre);
            } else {
                Genre newGenre = new Genre(genres[i], plays[i]);
                newGenre.list.add(new Music(plays[i], i));
                map.put(genres[i], newGenre);
            }
        }
        
        List<Genre> g = new ArrayList<>();
        for(String title : map.keySet()){
            g.add(map.get(title));
        }
        
        Collections.sort(g, new Comparator<Genre>(){
            @Override
            public int compare(Genre o1, Genre o2) {
                return o2.totalNum - o1.totalNum;
            }
        });
        
        List<Integer> listAnswer = new ArrayList<>();
        for(int i = 0; i < g.size(); i++) {
            Genre curGenre = g.get(i);
            Collections.sort(curGenre.list);
            
            listAnswer.add(curGenre.list.get(0).musicNum);
            if(curGenre.list.size() > 1) listAnswer.add(curGenre.list.get(1).musicNum);
        }
        
        // System.out.println(listAnswer);
        int[] answer = new int[listAnswer.size()];
        
        for(int i = 0; i <answer.length; i++) {
            answer[i] = listAnswer.get(i);
        }
        return answer;
    }
}