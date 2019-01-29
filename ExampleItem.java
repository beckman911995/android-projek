package firmansyahprojek.myapplicationkitten;

/**
 * Created by USER on 23/01/2019.
 */

public class ExampleItem {
    private String mImageUrl;
    private String mCreator;
    private int mLikes;

    public ExampleItem (String imageUrl, String creator, int likes){
        mImageUrl = imageUrl;
        mCreator = creator;
        mLikes = likes;
    }

    public String getImageUrl(){
        return mImageUrl;
    }
    public String getCreator(){
        return mCreator;
    }
    public int getlikeCount(){
        return mLikes;
    }
}
