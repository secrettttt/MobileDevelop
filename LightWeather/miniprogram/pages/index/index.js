// miniprogram/pages/js/js.js

var app = getApp()
var otherTmp = [1, 2, 3];
var otherTxt = [];
var otherCode = [];
var otherQlty = [];
var otherDir = [];
var otherSc = [];
var otherHum = [];
var otherF1 = [];
var otherDaily_forecast = [];
var day = ["今天", "明天", "后天"];
var cityList = [
  '北京',
  '上海',
  '广州',
  '深圳',
  '杭州',
  '南京',
  '天津',
  '成都',
  '重庆',
  '西安',
  '武汉',
  '长沙',
  '合肥',
  '南昌',
  '贵阳',
  '昆明',
  '南宁',
  '济南',
  '郑州',
  '石家庄',
  '兰州',
  '哈尔滨',
  '长春',
  '沈阳',
  '呼和浩特',
  '乌鲁木齐',
  '拉萨'
];

Page({
  data: {
    day: day,
    otherTmp: otherTmp,
    otherTxt: otherTxt,
    otherCode: otherCode,
    otherQlty: otherQlty,
    otherDir: otherDir,
    otherSc: otherSc,
    otherHum: otherHum,
    otherF1: otherF1,
    otherDaily_forecast: otherDaily_forecast,
    swiperIndex: 0 //这里不写第一次启动展示的时候会有问题
  },

  onLoad: function() {
    console.log('onLoad')
    var that = this
    that.getLocation();
  },

  onReady: function() {
    //获得dialog组件
    this.dialog = this.selectComponent("#dialog");
  },

  //获取经纬度方法
  getLocation: function() {
    var that = this
    wx.getLocation({
      type: 'wgs84',
      success: function(res) {
        var latitude = res.latitude
        var longitude = res.longitude
        console.log("lat:" + latitude + " lon:" + longitude);
        that.getCity(latitude, longitude);
      }
    })
  },

  //获取城市信息
  getCity: function(latitude, longitude) {
    var that = this
    var url = "https://api.map.baidu.com/geocoder/v2/";
    var params = {
      ak: "ASAT5N3tnHIa4APW0SNPeXN5",
      location: latitude + "," + longitude,
      output: "json",
      pois: 0
    }
    wx.request({
      url: url,
      data: params,
      success: function(res) {
        var city = res.data.result.addressComponent.city;
        var district = res.data.result.addressComponent.district;
        var street = res.data.result.addressComponent.street;

        that.setData({
          city: city,
          district: district,
          street: street,
        })

        var descCity = city.substring(0, city.length - 1);
        that.getWeahter(descCity);
        console.log(descCity)
      },
      fail: function(res) {},
      complete: function(res) {},
    })
  },
  //获取天气信息
  getWeahterChongqing: function () {
    var that = this
    var url = "https://free-api.heweather.com/s6/weather/now?location=" + "重庆" + "&key=83fcb76ad2914d44a186e2ed68581879"
    var params = {
      city: '重庆',
      key: "83fcb76ad2914d44a186e2ed68581879"
    }
    wx.request({
      url: url,
      data: params,
      success: function (res) {
        var tmp = res.data.HeWeather6[0].now.tmp;
        var txt = res.data.HeWeather6[0].now.cond_txt;
        var code = res.data.HeWeather6[0].now.cond_code;
        var dir = res.data.HeWeather6[0].now.wind_dir;
        var sc = res.data.HeWeather6[0].now.wind_sc;
        var hum = res.data.HeWeather6[0].now.hum;
        var fl = res.data.HeWeather6[0].now.fl;
        that.setData({
          cqtmp: tmp,
          cqtxt: txt,
          cqcode: code,
          cqdir: dir,
          cqsc: sc,
          cqhum: hum,
          cqfl: fl,
        })
        that.setBackground(10, code);
      },
      fail: function (res) { },
      complete: function (res) { },
    })
    wx.request({
      url: "https://free-api.heweather.com/s6/air/now?location=" + "重庆" + "&key=83fcb76ad2914d44a186e2ed68581879",
      data: params,
      success: function (res) {
        var qlty = res.data.HeWeather6[0].air_now_city.qlty;
        that.setData({
          cqqlty: qlty,
        })
      },
      fail: function (res) { },
      complete: function (res) { },
    })
  },

  //获取天气信息
  getWeahterChengdu: function () {
    var that = this
    var url = "https://free-api.heweather.com/s6/weather/now?location=" + "成都" + "&key=83fcb76ad2914d44a186e2ed68581879"
    var params = {
      city: '成都',
      key: "83fcb76ad2914d44a186e2ed68581879"
    }
    wx.request({
      url: url,
      data: params,
      success: function (res) {
        var tmp = res.data.HeWeather6[0].now.tmp;
        var txt = res.data.HeWeather6[0].now.cond_txt;
        var code = res.data.HeWeather6[0].now.cond_code;
        var dir = res.data.HeWeather6[0].now.wind_dir;
        var sc = res.data.HeWeather6[0].now.wind_sc;
        var hum = res.data.HeWeather6[0].now.hum;
        var fl = res.data.HeWeather6[0].now.fl;
        that.setData({
          cdtmp: tmp,
          cdtxt: txt,
          cdcode: code,
          cddir: dir,
          cdsc: sc,
          cdhum: hum,
          cdfl: fl,
        })
        that.setBackground(9, code);
      },
      fail: function (res) { },
      complete: function (res) { },
    })
    wx.request({
      url: "https://free-api.heweather.com/s6/air/now?location=" + "成都" + "&key=83fcb76ad2914d44a186e2ed68581879",
      data: params,
      success: function (res) {
        var qlty = res.data.HeWeather6[0].air_now_city.qlty;
        that.setData({
          cdqlty: qlty,
        })
        that.getWeahterChongqing();
      },
      fail: function (res) { },
      complete: function (res) { },
    })
  },
  //获取天气信息
  getWeahterTianjin: function () {
    var that = this
    var url = "https://free-api.heweather.com/s6/weather/now?location=" + "天津" + "&key=83fcb76ad2914d44a186e2ed68581879"
    var params = {
      city: '天津',
      key: "83fcb76ad2914d44a186e2ed68581879"
    }
    wx.request({
      url: url,
      data: params,
      success: function (res) {
        var tmp = res.data.HeWeather6[0].now.tmp;
        var txt = res.data.HeWeather6[0].now.cond_txt;
        var code = res.data.HeWeather6[0].now.cond_code;
        var dir = res.data.HeWeather6[0].now.wind_dir;
        var sc = res.data.HeWeather6[0].now.wind_sc;
        var hum = res.data.HeWeather6[0].now.hum;
        var fl = res.data.HeWeather6[0].now.fl;
        that.setData({
          tjtmp: tmp,
          tjtxt: txt,
          tjcode: code,
          tjdir: dir,
          tjsc: sc,
          tjhum: hum,
          tjfl: fl,
        })
        that.setBackground(8, code);
      },
      fail: function (res) { },
      complete: function (res) { },
    })
    wx.request({
      url: "https://free-api.heweather.com/s6/air/now?location=" + "天津" + "&key=83fcb76ad2914d44a186e2ed68581879",
      data: params,
      success: function (res) {
        var qlty = res.data.HeWeather6[0].air_now_city.qlty;
        that.setData({
          tjqlty: qlty,
        })
        that.getWeahterChengdu();
      },
      fail: function (res) { },
      complete: function (res) { },
    })
  },
  //获取天气信息
  getWeahterWuhan: function () {
    var that = this
    var url = "https://free-api.heweather.com/s6/weather/now?location=" + "武汉" + "&key=83fcb76ad2914d44a186e2ed68581879"
    var params = {
      city: '武汉',
      key: "83fcb76ad2914d44a186e2ed68581879"
    }
    wx.request({
      url: url,
      data: params,
      success: function (res) {
        var tmp = res.data.HeWeather6[0].now.tmp;
        var txt = res.data.HeWeather6[0].now.cond_txt;
        var code = res.data.HeWeather6[0].now.cond_code;
        var dir = res.data.HeWeather6[0].now.wind_dir;
        var sc = res.data.HeWeather6[0].now.wind_sc;
        var hum = res.data.HeWeather6[0].now.hum;
        var fl = res.data.HeWeather6[0].now.fl;
        that.setData({
          whtmp: tmp,
          whtxt: txt,
          whcode: code,
          whdir: dir,
          whsc: sc,
          whhum: hum,
          whfl: fl,
        })
        that.setBackground(7, code);
      },
      fail: function (res) { },
      complete: function (res) { },
    })
    wx.request({
      url: "https://free-api.heweather.com/s6/air/now?location=" + "武汉" + "&key=83fcb76ad2914d44a186e2ed68581879",
      data: params,
      success: function (res) {
        var qlty = res.data.HeWeather6[0].air_now_city.qlty;
        that.setData({
          whqlty: qlty,
        })
        that.getWeahterTianjin();
      },
      fail: function (res) { },
      complete: function (res) { },
    })
  },
  //获取天气信息
  getWeahterNanjing: function () {
    var that = this
    var url = "https://free-api.heweather.com/s6/weather/now?location=" + "南京" + "&key=83fcb76ad2914d44a186e2ed68581879"
    var params = {
      city: '南京',
      key: "83fcb76ad2914d44a186e2ed68581879"
    }
    wx.request({
      url: url,
      data: params,
      success: function (res) {
        var tmp = res.data.HeWeather6[0].now.tmp;
        var txt = res.data.HeWeather6[0].now.cond_txt;
        var code = res.data.HeWeather6[0].now.cond_code;
        var dir = res.data.HeWeather6[0].now.wind_dir;
        var sc = res.data.HeWeather6[0].now.wind_sc;
        var hum = res.data.HeWeather6[0].now.hum;
        var fl = res.data.HeWeather6[0].now.fl;
        that.setData({
          njtmp: tmp,
          njtxt: txt,
          njcode: code,
          njdir: dir,
          njsc: sc,
          njhum: hum,
          njfl: fl,
        })
        that.setBackground(6, code);
      },
      fail: function (res) { },
      complete: function (res) { },
    })
    wx.request({
      url: "https://free-api.heweather.com/s6/air/now?location=" + "南京" + "&key=83fcb76ad2914d44a186e2ed68581879",
      data: params,
      success: function (res) {
        var qlty = res.data.HeWeather6[0].air_now_city.qlty;
        that.setData({
          njqlty: qlty,
        })
        that.getWeahterWuhan();
      },
      fail: function (res) { },
      complete: function (res) { },
    })
  },
  //获取天气信息
  getWeahterHangzhou: function () {
    var that = this
    var url = "https://free-api.heweather.com/s6/weather/now?location=" + "杭州" + "&key=83fcb76ad2914d44a186e2ed68581879"
    var params = {
      city: '杭州',
      key: "83fcb76ad2914d44a186e2ed68581879"
    }
    wx.request({
      url: url,
      data: params,
      success: function (res) {
        var tmp = res.data.HeWeather6[0].now.tmp;
        var txt = res.data.HeWeather6[0].now.cond_txt;
        var code = res.data.HeWeather6[0].now.cond_code;
        var dir = res.data.HeWeather6[0].now.wind_dir;
        var sc = res.data.HeWeather6[0].now.wind_sc;
        var hum = res.data.HeWeather6[0].now.hum;
        var fl = res.data.HeWeather6[0].now.fl;
        that.setData({
          hztmp: tmp,
          hztxt: txt,
          hzcode: code,
          hzdir: dir,
          hzsc: sc,
          hzhum: hum,
          hzfl: fl,
        })
        that.setBackground(5, code);
      },
      fail: function (res) { },
      complete: function (res) { },
    })
    wx.request({
      url: "https://free-api.heweather.com/s6/air/now?location=" + "杭州" + "&key=83fcb76ad2914d44a186e2ed68581879",
      data: params,
      success: function (res) {
        var qlty = res.data.HeWeather6[0].air_now_city.qlty;
        that.setData({
          hzqlty: qlty,
        })
        that.getWeahterNanjing();
      },
      fail: function (res) { },
      complete: function (res) { },
    })
  },
  //获取天气信息
  getWeahterShenzhen: function () {
    var that = this
    var url = "https://free-api.heweather.com/s6/weather/now?location=" + "深圳" + "&key=83fcb76ad2914d44a186e2ed68581879"
    var params = {
      city: '深圳',
      key: "83fcb76ad2914d44a186e2ed68581879"
    }
    wx.request({
      url: url,
      data: params,
      success: function (res) {
        var tmp = res.data.HeWeather6[0].now.tmp;
        var txt = res.data.HeWeather6[0].now.cond_txt;
        var code = res.data.HeWeather6[0].now.cond_code;
        var dir = res.data.HeWeather6[0].now.wind_dir;
        var sc = res.data.HeWeather6[0].now.wind_sc;
        var hum = res.data.HeWeather6[0].now.hum;
        var fl = res.data.HeWeather6[0].now.fl;
        that.setData({
          sztmp: tmp,
          sztxt: txt,
          szcode: code,
          szdir: dir,
          szsc: sc,
          szhum: hum,
          szfl: fl,
        })
        that.setBackground(4, code);
      },
      fail: function (res) { },
      complete: function (res) { },
    })
    wx.request({
      url: "https://free-api.heweather.com/s6/air/now?location=" + "深圳" + "&key=83fcb76ad2914d44a186e2ed68581879",
      data: params,
      success: function (res) {
        var qlty = res.data.HeWeather6[0].air_now_city.qlty;
        that.setData({
          szqlty: qlty,
        })
        that.getWeahterHangzhou();
      },
      fail: function (res) { },
      complete: function (res) { },
    })
  },

  //获取天气信息
  getWeahterGuangzhou: function () {
    var that = this
    var url = "https://free-api.heweather.com/s6/weather/now?location=" + "广州" + "&key=83fcb76ad2914d44a186e2ed68581879"
    var params = {
      city: '广州',
      key: "83fcb76ad2914d44a186e2ed68581879"
    }
    wx.request({
      url: url,
      data: params,
      success: function (res) {
        var tmp = res.data.HeWeather6[0].now.tmp;
        var txt = res.data.HeWeather6[0].now.cond_txt;
        var code = res.data.HeWeather6[0].now.cond_code;
        var dir = res.data.HeWeather6[0].now.wind_dir;
        var sc = res.data.HeWeather6[0].now.wind_sc;
        var hum = res.data.HeWeather6[0].now.hum;
        var fl = res.data.HeWeather6[0].now.fl;
        that.setData({
          gztmp: tmp,
          gztxt: txt,
          gzcode: code,
          gzdir: dir,
          gzsc: sc,
          gzhum: hum,
          gzfl: fl,
        })
        that.setBackground(3, code);
      },
      fail: function (res) { },
      complete: function (res) { },
    })
    wx.request({
      url: "https://free-api.heweather.com/s6/air/now?location=" + "广州" + "&key=83fcb76ad2914d44a186e2ed68581879",
      data: params,
      success: function (res) {
        var qlty = res.data.HeWeather6[0].air_now_city.qlty;
        that.setData({
          gzqlty: qlty,
        })
        that.getWeahterShenzhen();
      },
      fail: function (res) { },
      complete: function (res) { },
    })
  },
  //获取天气信息
  getWeahterShanghai: function (y) {
    var that = this
    var url = "https://free-api.heweather.com/s6/weather/now?location=" + "上海" + "&key=83fcb76ad2914d44a186e2ed68581879"
    var params = {
      city: '上海',
      key: "83fcb76ad2914d44a186e2ed68581879"
    }
    wx.request({
      url: url,
      data: params,
      success: function (res) {
        var tmp = res.data.HeWeather6[0].now.tmp;
        var txt = res.data.HeWeather6[0].now.cond_txt;
        var code = res.data.HeWeather6[0].now.cond_code;
        var dir = res.data.HeWeather6[0].now.wind_dir;
        var sc = res.data.HeWeather6[0].now.wind_sc;
        var hum = res.data.HeWeather6[0].now.hum;
        var fl = res.data.HeWeather6[0].now.fl;
        that.setData({
          shtmp: tmp,
          shtxt: txt,
          shcode: code,
          shdir: dir,
          shsc: sc,
          shhum: hum,
          shfl: fl,
        })
        that.setBackground(2, code);
      },
      fail: function (res) { },
      complete: function (res) { },
    })
    wx.request({
      url: "https://free-api.heweather.com/s6/air/now?location=" + "上海" + "&key=83fcb76ad2914d44a186e2ed68581879",
      data: params,
      success: function (res) {
        var qlty = res.data.HeWeather6[0].air_now_city.qlty;
        that.setData({
          shqlty: qlty,
        })
        that.getWeahterGuangzhou();
      },
      fail: function (res) { },
      complete: function (res) { },
    })
  },
  //获取天气信息
  getWeahterBeijing: function () {
    var that = this
    var url = "https://free-api.heweather.com/s6/weather/now?location=" + "北京" + "&key=83fcb76ad2914d44a186e2ed68581879"
    var params = {
      city: '北京',
      key: "83fcb76ad2914d44a186e2ed68581879"
    }
    wx.request({
      url: url,
      data: params,
      success: function (res) {
        var tmp = res.data.HeWeather6[0].now.tmp;
        var txt = res.data.HeWeather6[0].now.cond_txt;
        var code = res.data.HeWeather6[0].now.cond_code;
        var dir = res.data.HeWeather6[0].now.wind_dir;
        var sc = res.data.HeWeather6[0].now.wind_sc;
        var hum = res.data.HeWeather6[0].now.hum;
        var fl = res.data.HeWeather6[0].now.fl;
        that.setData({
          bjtmp: tmp,
          bjtxt: txt,
          bjcode: code,
          bjdir: dir,
          bjsc: sc,
          bjhum: hum,
          bjfl: fl,
        })
        that.setBackground(1, code);
      },
      fail: function (res) { },
      complete: function (res) { },
    })
    wx.request({
      url: "https://free-api.heweather.com/s6/air/now?location=" + "北京" + "&key=83fcb76ad2914d44a186e2ed68581879",
      data: params,
      success: function (res) {
        var qlty = res.data.HeWeather6[0].air_now_city.qlty;
        that.setData({
          bjqlty: qlty,
        })
        that.getWeahterShanghai();
      },
      fail: function (res) { },
      complete: function (res) { },
    })
  },

  //获取天气信息
  getWeahter: function(city) {
    var that = this
    var url = "https://free-api.heweather.com/s6/weather/now?location="+city+"&key=83fcb76ad2914d44a186e2ed68581879"
    var params = {
      city: city,
      key: "83fcb76ad2914d44a186e2ed68581879"
    }
    wx.request({
      url: url,
      data: params,
      success: function(res) {
        var tmp = res.data.HeWeather6[0].now.tmp;
        var txt = res.data.HeWeather6[0].now.cond_txt;
        var code = res.data.HeWeather6[0].now.cond_code;
        var dir = res.data.HeWeather6[0].now.wind_dir;
        var sc = res.data.HeWeather6[0].now.wind_sc;
        var hum = res.data.HeWeather6[0].now.hum;
        var fl = res.data.HeWeather6[0].now.fl;
        that.setData({
          tmp: tmp,
          txt: txt,
          code: code,
          dir: dir,
          sc: sc,
          hum: hum,
          fl: fl,
        })
        that.setBackground(0, code);
      },
      fail: function(res) {},
      complete: function(res) {},
    })
    wx.request({
      url: "https://free-api.heweather.com/s6/air/now?location=" + city +"&key=83fcb76ad2914d44a186e2ed68581879",
      data: params,
      success: function (res) {
        var qlty = res.data.HeWeather6[0].air_now_city.qlty;
        that.setData({
          qlty: qlty,
        })
        that.getWeahterBeijing();
      },
      fail: function (res) { },
      complete: function (res) { },
    })
  },

  //根据当前天气设置背景图片
  setBackground: function(cityNumber, code) {
    var nowTime = new Date();
    var nowHour = nowTime.getHours(); //获取当前小时数(0-23)
    var nowWeatherStatus = code;
    var c;
    if (nowHour <= 6 && nowHour >= 19) {
      //夜晚
      if (100 <= nowWeatherStatus && nowWeatherStatus <= 213) {
        c = 12;
      } else if (300 <= nowWeatherStatus && nowWeatherStatus <= 399) {
        c = 7;
      } else if (400 <= nowWeatherStatus && nowWeatherStatus <= 499) {
        c = 9;
      } else {
        c = 12;
      }
    } else {
      //白天
      if (nowWeatherStatus == 100) {
        c = 1;
      } else if (101 <= nowWeatherStatus && nowWeatherStatus <= 103) {
        c = 2;
      } else if (104 <= nowWeatherStatus && nowWeatherStatus <= 213) {
        c = 3;
      } else if (300 <= nowWeatherStatus && nowWeatherStatus <= 399) {
        if (302 <= nowWeatherStatus && nowWeatherStatus <= 304) {
          c = 5;
        } else {
          c = 6;
        }
      } else if (400 <= nowWeatherStatus && nowWeatherStatus <= 499) {
        c = 8;
      } else if (500 <= nowWeatherStatus && nowWeatherStatus <= 515) {
        if (503 <= nowWeatherStatus && nowWeatherStatus <= 508) {
          c = 11;
        } else {
          c = 12;
        }
      } else {
        c = 1;
      }
    }
    console.log(cityNumber + " " + c);
    switch (cityNumber) {
      case 0:
        this.setData({
          backgroundCode: c
        });
        break;
      case 1:
        this.setData({
          bjbackgroundCode: c
        });
        break;
      case 2:
        this.setData({
          shbackgroundCode: c
        });
        break;
      case 3:
        this.setData({
          gzbackgroundCode: c
        });
        break;
      case 4:
        this.setData({
          szbackgroundCode: c
        });
        break;
      case 5:
        this.setData({
          hzbackgroundCode: c
        });
        break;
      case 6:
        this.setData({
          njbackgroundCode: c
        });
        break;
      case 7:
        this.setData({
          whbackgroundCode: c
        });
        break;
      case 8:
        this.setData({
          tjbackgroundCode: c
        });
        break;
      case 9:
        this.setData({
          cdbackgroundCode: c
        });
        break;
      case 10:
        this.setData({
          cqbackgroundCode: c
        });
        break;
    }
  },
  changeCity: function() {
    //do something
    console.log("changeCity")
    wx.navigateTo({
      url: '../js/js',
    })
  },
  changeTheme: function() {
    //do something
    console.log("changeTheme")
    this.dialog.showDialog();
  },
  bindchange(e) {
    this.setData({
      swiperIndex: e.detail.current
    })
  },
})