import java.util.*;

public class Twitter{
          int tweet_no;
          Map<Integer,List<List<Integer>>> mapUserTweet  = new HashMap<>();
          Map<Integer,Set<Integer>> getUserFollow = new HashMap<>();

    public Twitter(){
       tweet_no = 0;
    }

    public void postTweet(int userId, int tweetId) {
        tweet_no++;
                if(mapUserTweet.containsKey(userId)){
                    List<Integer> list = new ArrayList<>();
                    list.add(tweetId);
                    list.add(tweet_no);
                    var mainList = mapUserTweet.get(userId);
                    mainList.add(list);

                    mapUserTweet.put(userId,mainList);
                }else{
                    List<Integer> list = new ArrayList<>();
                    list.add(tweetId);
                    list.add(tweet_no);
                    List<List<Integer>> mainList = new ArrayList<>();
                    mainList.add(list);
                    mapUserTweet.put(userId,mainList);

                }
     }

    public List<Integer> getNewsFeed(int userId) {
          List<Integer> list = new ArrayList<>();

          if(getUserFollow.containsKey(userId)){
              var list2 = getUserFollow.get(userId);
              for (var Id : list2){
                  list.add(Id);
              }
              Queue<Integer> queue = new PriorityQueue<>();
              for (var l : list){
                  if(!mapUserTweet.containsKey(l))
                      continue;

                  var l2 = mapUserTweet.get(l);
                  for(var  l3 : l2){
                      queue.add(-1*l3.get(1));
                  }
              }

              List<Integer> returnList = new ArrayList<>();
              int count = 0;
              while (!queue.isEmpty()){
                  if(count == 10)
                      break;
                  var root = -1*queue.poll();

                  for (var mapKey : mapUserTweet.entrySet()){
                      int anyChange = returnList.size();
                      var listy = mapKey.getValue();
                   for(var l : listy){
                       if(l.get(1) == root){
                           returnList.add(l.get(0));
                           count++;
                           break;
                       }
                   }
                   if(anyChange<returnList.size()){
                       break;
                   }
                  }


              }

              return returnList;


          }


          else if(mapUserTweet.containsKey(userId))
        {
              var returnlist = mapUserTweet.get(userId);
              List<Integer> result = new ArrayList<>();
            int count2 = 0;
              for(int i = returnlist.size()-1;i>=0;i--){
                  if(count2 == 10)
                      break;
                  result.add(returnlist.get(i).get(0));
                  count2++;
              }
              return result;
          }
          else
              return new ArrayList<>();
    }

    public void follow(int followerId, int followeeId){

          if(getUserFollow.containsKey(followerId)){
             var list = getUserFollow.get(followerId);
             list.add(followeeId);
             getUserFollow.put(followerId,list);
          }
          else
          {
              Set<Integer> newList = new HashSet<>();
              newList.add(followerId);
              newList.add(followeeId);
              getUserFollow.put(followerId,newList);
          }
    }

    public void unfollow(int followerId, int followeeId){

       if(!getUserFollow.containsKey(followerId))
           return;

        var removeList = getUserFollow.get(followerId);
        int index = 0;
        for(var id : removeList){
            if(followeeId == id)
                break;
            else
                index++;
        }
        if(index == removeList.size())
            return;
        List<Integer> newList = new ArrayList<>(removeList);
        removeList.remove(newList.get(index));
        getUserFollow.put(followerId,removeList);

    }

}
