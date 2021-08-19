import http from 'k6/http';

export let options = {
  discardResponseBodies: true,
  scenarios: {
    contacts: {
      executor: 'ramping-vus',
      startVUs: 0,
      stages: [
        { duration: '10s', target: 50 },
        { duration: '15s', target: 50 },
        {duration:'10s',target:0}
      ],
      gracefulRampDown: '0s',
    },
  },
};

export default function () {

 var params = {
    headers: {
      'Authorization': 'Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsiY291cG9uc2VydmljZSJdLCJ1c2VyX25hbWUiOiJmYWl6QGdtYWlsLmNvbSIsInNjb3BlIjpbInJlYWQiLCJ3cml0ZSJdLCJleHAiOjE2MjkxNTQ1OTcsImF1dGhvcml0aWVzIjpbIlJPTEVfQURNSU4iXSwianRpIjoiMzllNGVkMDktMjcyZS00NDI2LTljMTMtZDczNDc4ZTljNjgxIiwiY2xpZW50X2lkIjoiY291cG9uY2xpZW50YXBwIn0.IQo-Q-k1CQ5UjzGAEH2DOYtL9qP7PKozCS-oHxHSEkw'
    },
  };
  http.get('https://eldorado-shop.net/api/product/customer/products?view=1',params)
}
