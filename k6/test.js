import http from 'k6/http';
import { sleep, check } from 'k6';

export let options = {
  stages: [
    { duration: '10s', target: 5 },
    { duration: '20s', target: 20 },
    { duration: '10s', target: 0 },
  ],
};

export default function () {
  const theaterId = 2;
  const BASE_URL = 'http://localhost:8080';
  let res = http.get(`${BASE_URL}/movies?theater_id=${theaterId}`);

  check(res, {
    'status is 200': (r) => r.status === 200,
    'response time < 500ms': (r) => r.timings.duration < 500,
    'response body is not empty': (r) => {
      try {
        const json = r.json();
        return Array.isArray(json) && json.length > 0;
      } catch (e) {
        return false;
      }
    },
  });

  sleep(1);
}