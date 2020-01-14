// components/dialog/dialog.js
Component({
  options: {
    multipleSlots: true // 在组件定义时的选项中启用多slot支持
  },
  /**
   * 组件的属性列表
   */
  properties: {
  },

  /**
   * 组件的初始数据
   */
  data: {
    // 弹窗显示控制
    isShow: false
  },
  

  /**
   * 组件的方法列表
   */
  methods: {
    /*
     * 公有方法
     */
    
    //隐藏弹框
    hideDialog() {
      this._showOrCloseDialog("close")
    },
    //展示弹框
    showDialog() {
      this._showOrCloseDialog("open")
    },
    /*
     * 内部私有方法建议以下划线开头
     * triggerEvent 用于触发事件
     */
    
    addSubscribe: function (e) {
      wx.setStorageSync('newSubscribe', e.currentTarget.dataset.text)
      var username = wx.getStorageSync('newname');
      
      wx.request({
        url: 'https://www.kprun.club/index.php/api/Index/sub_in',
        // 访问的域名路径/要绝对路径
        header: {
          "Content-Type": "application/x-www-form-urlencoded"
        },
        method: "POST",
        data: { username: username, subscribe: e.currentTarget.dataset.text },
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
              url: '../../pages/personalsubscribe/personalsubscribe',
            })
          }
        }
      })


    },



    _showOrCloseDialog: function (currentStatu) {
      var that = this;
      /* 动画部分 */
      // 第1步：创建动画实例 
      var animation = wx.createAnimation({
        duration: 200, //动画时长
        timingFunction: "linear", //线性
        delay: 0 //0则不延迟
      });

      // 第2步：这个动画实例赋给当前的动画实例
      this.animation = animation;

      // 第3步：执行第一组动画
      animation.opacity(0).rotateX(-100).step();

      // 第4步：导出动画对象赋给数据对象储存
      that.setData({
        animationData: animation.export()
      })

      // 第5步：设置定时器到指定时候后，执行第二组动画
      setTimeout(function () {
        // 执行第二组动画
        animation.opacity(1).rotateX(0).step();
        // 给数据对象储存的第一组动画，更替为执行完第二组动画的动画对象
        that.setData({
          animationData: animation
        })

        //关闭
        if (currentStatu == "close") {
          that.setData({
            isShow: false
          });
        }
      }.bind(this), 200)

      // 显示
      if (currentStatu == "open") {
        that.setData({
          isShow: true
        });
      }
    }
  },
  //解决滚动穿透问题
  myCatchTouch: function () {
    return
  }
})
