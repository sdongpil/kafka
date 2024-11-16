import http from 'k6/http';
import { check, sleep } from 'k6';

export let options = {
  vus: 30,
  duration: '10s',
};

export default function () {
  const url = 'http://localhost:8080/api/coupon';

  const payload = JSON.stringify({
    userId: 1
  });

  const params = {
    headers: {
      'Content-Type': 'application/json',
    },
  };

  const res = http.post(url, payload, params);

  // 응답 검사
  check(res, {
    'status is 200': (r) => r.status === 200,
  });

  sleep(1);
}

