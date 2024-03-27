import java.util.*;
import java.io.*;
    
class Solution {
    
    static class Genre{
        int totalCnt;
        List<Music> musics = new ArrayList<>();
    }
    
    static class Music {
        int number;
        int play;
        Music(int number, int play) {
            this.number = number;
            this.play = play;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        
        int L = genres.length;
        
        //토탈 몇개인지 확인
        Map<String, Genre> map = new HashMap<>();
        
        for(int i = 0; i < L; i++) {
            String genre = genres[i];
            int play = plays[i];
            
            Genre curGenre;
            
            if(map.containsKey(genre)) {
                curGenre = map.get(genre);
            } else curGenre = new Genre();
            curGenre.totalCnt+=play;
            // System.out.println(curGenre.totalCnt);
            
            curGenre.musics.add(new Music(i, play));
            
            map.put(genre, curGenre);
        }
        List<Genre> list = new ArrayList<>();
        
        for(String key : map.keySet()){
            Genre genre = map.get(key);
            list.add(genre);
            Collections.sort(genre.musics, (o1, o2) -> {
                if(o2.play > o1.play) return 1;
                else if(o2.play == o1.play) return o1.number - o2.number;
                else return -1;
            });
        }
        
        Collections.sort(list, (o1, o2) -> {
            return o2.totalCnt - o1.totalCnt;
        });
        
        List<Integer> list2 = new ArrayList<>();
        for(int i = 0; i < list.size(); i++) {
            
            List<Music> musics = list.get(i).musics;
            Collections.sort(musics, (o1, o2) -> {
                if(o2.play > o1.play) return 1;
                else if(o2.play == o1.play) return o1.number - o2.number;
                else return -1;
            });
            
            if(musics.size() > 1) {
                list2.add(musics.get(0).number);
                list2.add(musics.get(1).number);
            } else list2.add(musics.get(0).number);
        }
        
        int[] answer = new int[list2.size()];
        for(int i = 0; i < list2.size(); i++) {
            answer[i] = list2.get(i);
        }
        
        return answer;
    }
}