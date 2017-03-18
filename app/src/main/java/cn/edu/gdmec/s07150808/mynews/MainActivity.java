package cn.edu.gdmec.s07150808.mynews;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import cn.edu.gdmec.s07150808.mynews.Date.NewsAdapter;
import cn.edu.gdmec.s07150808.mynews.Date.NewsBeam;
import cn.edu.gdmec.s07150808.mynews.TabUtil.AddressFragment;
import cn.edu.gdmec.s07150808.mynews.TabUtil.FrdFragment;
import cn.edu.gdmec.s07150808.mynews.TabUtil.SettingFragment;
import cn.edu.gdmec.s07150808.mynews.TabUtil.WeixinFragment;

public class MainActivity extends FragmentActivity implements View.OnClickListener{


    private static final String urlPath = "http://www.imooc.com/api/teacher?type=4&num=30";
    //private static final String urlPath = "http://14.117.17.161/json.php";
    private ListView mListView;


  /*  private LinearLayout mTabWeixin;
    private LinearLayout mTabFrd;
    private LinearLayout mTabAddress;
    private LinearLayout mTabSettings;

    private ImageButton mImgWeixin;
    private ImageButton mImgFrd;
    private ImageButton mImgAddress;
    private ImageButton mImgSettings;

    private Fragment mTab01;
    private Fragment mTab02;
    private Fragment mTab03;
    private Fragment mTab04;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        initView();
        initEvent();
        setSelect(0);

    }


    private void initEvent()
    {
        mTabWeixin.setOnClickListener(this);
        mTabFrd.setOnClickListener(this);
        mTabAddress.setOnClickListener(this);
        mTabSettings.setOnClickListener(this);
    }

    private void initView()
    {
        mTabWeixin = (LinearLayout) findViewById(R.id.id_tab_weixin);
        mTabFrd = (LinearLayout) findViewById(R.id.id_tab_frd);
        mTabAddress = (LinearLayout) findViewById(R.id.id_tab_address);
        mTabSettings = (LinearLayout) findViewById(R.id.id_tab_settings);

        mImgWeixin = (ImageButton) findViewById(R.id.id_tab_weixin_img);
        mImgFrd = (ImageButton) findViewById(R.id.id_tab_frd_img);
        mImgAddress = (ImageButton) findViewById(R.id.id_tab_address_img);
        mImgSettings = (ImageButton) findViewById(R.id.id_tab_settings_img);

    }
    private void setSelect(int i)
    {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        hideFragment(transaction);

        switch (i)
        {
            case 0:
                if (mTab01 == null)
                {
                    mTab01 = new WeixinFragment();
                    transaction.add(R.id.id_content, mTab01);

                } else
                {
                    transaction.show(mTab01);
                }
                mImgWeixin.setImageResource(R.drawable.tab_weixin_pressed);

                break;
            case 1:
                if (mTab02 == null)
                {
                    mTab02 = new FrdFragment();transaction.add(R.id.id_content, mTab02);
                } else
                {
                    transaction.show(mTab02);

                }
                mImgFrd.setImageResource(R.drawable.tab_find_frd_pressed);
                break;
            case 2:
                if (mTab03 == null)
                {
                    mTab03 = new AddressFragment();
                    transaction.add(R.id.id_content, mTab03);
                } else
                {
                    transaction.show(mTab03);
                }
                mImgAddress.setImageResource(R.drawable.tab_address_pressed);
                break;
            case 3:
                if (mTab04 == null)
                {
                    mTab04 = new SettingFragment();
                    transaction.add(R.id.id_content, mTab04);
                } else
                {
                    transaction.show(mTab04);
                }
                mImgSettings.setImageResource(R.drawable.tab_settings_pressed);
                break;

            default:
                break;
        }

        transaction.commit();

    }
    private void hideFragment(FragmentTransaction transaction)
    {
        if (mTab01 != null)
        {
            transaction.hide(mTab01);
        }
        if (mTab02 != null)
        {
            transaction.hide(mTab02);
        }
        if (mTab03 != null)
        {
            transaction.hide(mTab03);
        }
        if (mTab04 != null)
        {
            transaction.hide(mTab04);
        }
    }

    @Override
    public void onClick(View v)
    {
        resetImgs();
        mListView = (ListView) findViewById(R.id.lv_main);
        new NewAsyncTask().execute(urlPath);
        switch (v.getId())
        {
            case R.id.id_tab_weixin:
                setSelect(0);

                break;
            case R.id.id_tab_frd:
                setSelect(1);
                break;
            case R.id.id_tab_address:
                setSelect(2);
                break;
            case R.id.id_tab_settings:
                setSelect(3);
                break;

            default:
                break;
        }
    }
    private void resetImgs()
    {
        mImgWeixin.setImageResource(R.drawable.tab_weixin_normal);
        mImgFrd.setImageResource(R.drawable.tab_find_frd_normal);
        mImgAddress.setImageResource(R.drawable.tab_address_normal);
        mImgSettings.setImageResource(R.drawable.tab_settings_normal);
    }
*/
  private ViewPager mViewPager;
    private PagerAdapter mAdapter;
    private List<View> mViews = new ArrayList<View>();
    // TAB

    private LinearLayout mTabWeixin;
    private LinearLayout mTabFrd;
    private LinearLayout mTabAddress;
    private LinearLayout mTabSetting;

    private ImageButton mWeixinImg;
    private ImageButton mFrdImg;
    private ImageButton mAddressImg;
    private ImageButton mSettingImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        initView();

        initEvents();


    }

    public void onWindowFocusChanged(boolean hasFocus)
    {
        if (hasFocus)
        {
            mListView = (ListView) findViewById(R.id.lv_main);
            new NewAsyncTask().execute(urlPath);
        }
    }
    @Override
    public void onClick(View v) {
        resetImg();
        switch (v.getId())
        {
            case R.id.id_tab_weixin:

                mViewPager.setCurrentItem(0);
                mWeixinImg.setImageResource(R.drawable.tab_weixin_pressed);
                break;
            case R.id.id_tab_frd:
                mViewPager.setCurrentItem(1);
                mFrdImg.setImageResource(R.drawable.tab_find_frd_pressed);
                break;
            case R.id.id_tab_address:
                mViewPager.setCurrentItem(2);
                mAddressImg.setImageResource(R.drawable.tab_address_pressed);
                break;
            case R.id.id_tab_settings:
                mViewPager.setCurrentItem(3);
                mSettingImg.setImageResource(R.drawable.tab_settings_pressed);
                break;

            default:
                break;
        }
    }

    /**
     * 将所有的图片切换为暗色的
     */
    private void resetImg()
    {
        mWeixinImg.setImageResource(R.drawable.tab_weixin_normal);
        mFrdImg.setImageResource(R.drawable.tab_find_frd_normal);
        mAddressImg.setImageResource(R.drawable.tab_address_normal);
        mSettingImg.setImageResource(R.drawable.tab_settings_normal);
    }


    private void initEvents()
    {
        mTabWeixin.setOnClickListener(this);
        mTabFrd.setOnClickListener(this);
        mTabAddress.setOnClickListener(this);
        mTabSetting.setOnClickListener(this);

        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
        {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int arg0)
            {
                int currentItem = mViewPager.getCurrentItem();
                resetImg();
                switch (currentItem)
                {
                    case 0:
                        mWeixinImg.setImageResource(R.drawable.tab_weixin_pressed);
                        break;
                    case 1:
                        mFrdImg.setImageResource(R.drawable.tab_find_frd_pressed);
                        break;
                    case 2:
                        mAddressImg
                                .setImageResource(R.drawable.tab_address_pressed);
                        break;
                    case 3:
                        mSettingImg
                                .setImageResource(R.drawable.tab_settings_pressed);
                        break;

                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }


        });
    }


    private void initView()
    {
        mViewPager = (ViewPager) findViewById(R.id.id_viewpager);
        // tabs
        mTabWeixin = (LinearLayout) findViewById(R.id.id_tab_weixin);
        mTabFrd = (LinearLayout) findViewById(R.id.id_tab_frd);
        mTabAddress = (LinearLayout) findViewById(R.id.id_tab_address);
        mTabSetting = (LinearLayout) findViewById(R.id.id_tab_settings);
        // ImageButton
        mWeixinImg = (ImageButton) findViewById(R.id.id_tab_weixin_img);
        mFrdImg = (ImageButton) findViewById(R.id.id_tab_frd_img);
        mAddressImg = (ImageButton) findViewById(R.id.id_tab_address_img);
        mSettingImg = (ImageButton) findViewById(R.id.id_tab_settings_img);

        LayoutInflater mInflater = LayoutInflater.from(this);
        View tab01 = mInflater.inflate(R.layout.tab01, null);
        View tab02 = mInflater.inflate(R.layout.tab02, null);
        View tab03 = mInflater.inflate(R.layout.tab03, null);
        View tab04 = mInflater.inflate(R.layout.tab04, null);
        mViews.add(tab01);
        mViews.add(tab02);
        mViews.add(tab03);
        mViews.add(tab04);


        mAdapter = new PagerAdapter()
        {

            @Override
            public void destroyItem(ViewGroup container, int position,
                                    Object object)
            {
                container.removeView(mViews.get(position));
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position)
            {
                View view = mViews.get(position);
                container.addView(view);

                return view;
            }

            @Override
            public boolean isViewFromObject(View arg0, Object arg1)
            {

                return arg0 == arg1;
            }

            @Override
            public int getCount()
            {

                return mViews.size();
            }

        };

        mViewPager.setAdapter(mAdapter);

    }

/*异步加载*/
    class NewAsyncTask extends AsyncTask<String, Void, List<NewsBeam>>
    {
        @Override
        protected void onPostExecute(List<NewsBeam> newsBeams)
        {
            super.onPostExecute(newsBeams);
            NewsAdapter adapter = new NewsAdapter(MainActivity.this, newsBeams, mListView);
            mListView.setAdapter(adapter);
        }
        @Override
        protected List<NewsBeam> doInBackground(String... params)
        {
            return getJsonData(params[0]);
        }


        /**
         * 从 URL 中获取数据
         *
         * @param url
         * @return
         */
        private List<NewsBeam> getJsonData(String url)
        {
            List<NewsBeam> newsBeamsList = new ArrayList<NewsBeam>();
            try
            {
                String jsonString = readStream(new URL(urlPath).openStream());

                JSONObject jsonObject;
                NewsBeam newsBeam;

                jsonObject = new JSONObject(jsonString);
                JSONArray jsonArray = jsonObject.getJSONArray("data");
                for(int i = 0; i < jsonArray.length(); i++)
                {
                    jsonObject = jsonArray.getJSONObject(i);
                    newsBeam = new NewsBeam();
                    newsBeam.newsIconUrl = jsonObject.getString("picSmall");
                    newsBeam.newsTitle = jsonObject.getString("name");
                    newsBeam.newsContent = jsonObject.getString("description");
                    newsBeamsList.add(newsBeam);
                }

            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
            catch(JSONException e)
            {
                e.printStackTrace();
            }
            return newsBeamsList;
        }


        /**
         * 从 inpustStream 获取的信息
         *
         * @param is
         * @return
         */
        private String readStream(InputStream is)
        {
            InputStreamReader isr;
            String result = "";
            try
            {
                isr = new InputStreamReader(is, "utf-8");
                BufferedReader br = new BufferedReader(isr);
                String line = "";
                while((line = br.readLine()) != null)
                {
                    result += line;
                }

            }
            catch(UnsupportedEncodingException e)
            {
                e.printStackTrace();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
            return result;
        }
    }
}
