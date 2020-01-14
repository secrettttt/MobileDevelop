// miniprogram/pages/personalsubscribe/personalsubscribe.js

function Detail(toplistName, toplistIconUrl) {
  this.toplistName = toplistName;
  this.toplistIconUrl = toplistIconUrl;
}
function Info() {
  this.details = [];
}

Page({

  /**
   * 页面的初始数据
   */
  data: {
 	info: {}
  },
  init: function () {
    let that = this;
    this.setData({
      info: new Info(),
    });
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log("dsds");
    var that = this;
    var username = wx.getStorageSync('newname');
   
    wx.request({
      url: 'https://www.kprun.club/index.php/api/Index/sub_on',
      // 访问的域名路径/要绝对路径
      header: {
        "Content-Type": "application/x-www-form-urlencoded; charset=UTF-8"
      },
      method: "POST",
      data: { username: username},
      success: function (res) {
        var temp = []
        for (var i = 0; i < res.data.banner.length;i++){
          var thisimg;
          switch (res.data.banner[i].subscribe) {
            case '知乎': thisimg='zhihu';break;
            case '微博': thisimg = 'weibo'; break;
            case '今日头条': thisimg = 'toutiao'; break;
            case '豆瓣': thisimg = 'douban'; break;
            case '知乎日报': thisimg = 'zhihuribao'; break;
            case '抖音': thisimg = 'douyin'; break;
            case '微信': thisimg = 'weixin'; break;
            case '知识精选': thisimg = 'zhishijingxuan'; break;
            case 'jianshu': thisimg = 'jianshu'; break;
            case '网易': thisimg = 'wangyi'; break;
            case '百度热搜': thisimg = 'baiduresou'; break;
            case '澎湃新闻': thisimg = 'pengpaixinwen'; break;
            case 'IT之家': thisimg = 'itzhijia'; break;
            case '中关村在线': thisimg = 'zhongguancunzaixian'; break;
            case '果壳': thisimg = 'guoke'; break;
            case '36Kr': thisimg = '36Kr'; break;  
            case '虎嗅': thisimg = 'huxiu'; break;
            case '少数派': thisimg = 'saoshupai'; break;
            case '雷科技': thisimg = 'leikeji'; break;
            case '快科技': thisimg = 'kuaikeji'; break;
            case '爱范': thisimg = 'aifan'; break;
            case '钛媒体': thisimg = 'taimeiti'; break;
            case '机器之心': thisimg = 'jiqizhixin'; break;
            case 'Bilibili': thisimg = 'bilibili'; break;
            case '涨姿势': thisimg = 'zhangzhishi'; break;
            case 'AcFun': thisimg = 'acfun'; break;
            case '趣头条': thisimg = 'qutoutiao'; break;
            case '场库': thisimg = 'changku'; break;
            case '马蜂窝': thisimg = 'mafengwo'; break;
            case '中关村在线': thisimg = 'zhongguancunzaixian'; break;
            case '果壳': thisimg = 'guoke'; break;
            case '机核': thisimg = 'jihe'; break;      
            case '猫扑': thisimg = 'maopu'; break;
            case '煎蛋': thisimg = 'jiandan'; break;
            case 'V2EX': thisimg = 'v2ex'; break;
            case '吾爱破解': thisimg = 'wuaipojie'; break;
            case '水木社区': thisimg = 'shuimushequ'; break;
            case '贴吧': thisimg = 'tieba'; break;
            case 'CbnData': thisimg = 'cbndata'; break;
            case '威锋社区': thisimg = 'weifengshequ'; break;   
            case '一亩三分地': thisimg = 'yimusanfendi'; break;
            case '汽车之家': thisimg = 'qichezhijia'; break;
            case '京东拼团': thisimg = 'jingdongpintuan'; break;
            case '京东秒杀': thisimg = 'jingdongmiaosha'; break;
            case '淘宝实时跑量榜': thisimg = 'taobaoshishipaoliangbang'; break;
            case '淘宝TOP销售榜': thisimg = 'taobaotopxiaoshoubang'; break;
            case '什么值得买': thisimg = 'shenmezhidemai'; break;
            case '京东自营（秒杀榜）': thisimg = 'jingdongzhiyingmiaoshabang'; break;   
            case '京东自营(热销榜）': thisimg = 'jingdongzhiyingrexiaobang'; break;
            case '京东热销榜': thisimg = 'jingdongrexiaobang'; break;
            case 'Github': thisimg = 'github'; break;
            case '开发者头条': thisimg = 'kaifazhetoutiao'; break;
            case '开源中国': thisimg = 'kaiyuanzhongguo'; break;
            case 'CSDN': thisimg = 'csdn'; break;  
            case 'Linux中国': thisimg = 'linuxzhongguo'; break;
            case '掘金': thisimg = 'juejin'; break;
            case '火星财经': thisimg = 'huoxingcaijing'; break;  
            case '币世界': thisimg = 'bishijie'; break;
            case '虎扑NBA': thisimg = 'hupunba'; break;
            case '火星财经': thisimg = 'huoxingcaijing'; break;  
            case '懂球帝': thisimg = 'dongqiudi'; break; 

                     }
          var tempItem={
            name: res.data.banner[i].name,
            subscribe: res.data.banner[i].subscribe,
            imgurl: thisimg
          }
          temp.push(tempItem);
        }
        that.setData({
          info: temp,
        })
        console.log(temp);
        if (res.data.code == 0) {
          wx.showToast({
            title: '提交失败！！！',
            icon: 'loading',
            duration: 1500
          })
        } else {
          wx.showToast({
            title: '提交成功！！！',//这里打印出登录成功
            icon: 'success',
            duration: 1000
          })
              
        }
      }
    })

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
    //获得dialog组件
    this.dialog = this.selectComponent("#dialog");
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  },
  gotoToplist: function (e) {
    console.log(e.currentTarget.dataset.variable);
    
    wx.navigateTo({
      url: '../toplist/toplist',
    })
    
    wx.setStorageSync('toplistTitle', e.currentTarget.dataset.variable)
  },
   _addEvent: function (e) {
     console.log("add")
     this.dialog.showDialog();
   
  },
  _deleteLotsEvent: function () {
    console.log("delete")
    this.removeItem()
  },
  removeItem: function (e) {
      var username = wx.getStorageSync('newname');
      wx.request({
        url: 'https://www.kprun.club/index.php/api/Index/del_all',
        // 访问的域名路径/要绝对路径
        header: {
          "Content-Type": "application/x-www-form-urlencoded"
        },
        method: "POST",
        data: { username: username},
        success: function (res) {

          console.log(res.data);
          if (res.data.code == 0) {
            wx.showToast({
              title: '提交失败！！！',
              icon: 'loading',
              duration: 1500
            })
          } else {
            wx.showToast({
              title: '提交成功！！！',//这里打印出登录成功
              icon: 'success',
              duration: 1000
            })
            wx.navigateTo({
              url: '../personalsubscribe/personalsubscribe',
            })
          }
        }
      })

  }
})