class Solution {

    //Map each course to its prerequisite.
    private Map<Integer,List<Integer>> preMap = new HashMap<>();

    //Store all courses along the current DFS path / store all the visitng courses.
    private Set<Integer> visiting = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        //Adding a empty list for every course preMap
        for(int i = 0;i < numCourses ;i++){
            preMap.put(i,new ArrayList<>());
        }

         //Appending/adding/Mapping all the prerequisting to the each case.
        for(int [] prequ : prerequisites ){
            preMap.get(prequ[0]).add(prequ[1]);
        }

        //dfs for each course 
        for(int c = 0; c < numCourses;c++){
            if(!dfs(c)){
                return false;
            }
        }
        return true; 
    }


    private boolean dfs(int crs){
        if(visiting.contains(crs)){
            //Cycle detected
            return false;
        }

        if(preMap.get(crs).isEmpty()){
            return true;
        }
         
         //neither a cycle is detected nor it is an empty 
        visiting.add(crs);
        for(int pre:preMap.get(crs)){
            if(!dfs(pre)){
                //cycle detected
                return false;
            }
        }
       
        //neither a cycle is detected nor it is an empty 
        visiting.remove(crs);
        preMap.put(crs,new ArrayList<>());
        return true;
    }
}
