import axios from 'axios';

const EMPLOYEE_SERVICE_BASE_URL = 'http://localhost:9191/api/employees';

const EMPLOYEE_ID = 8;
class EmployeeService {
	getEmployee() {
		return axios
			.get(`${EMPLOYEE_SERVICE_BASE_URL}/${EMPLOYEE_ID}`)
			.then((resp) => {
				console.log('response in service from getEmployee', resp);
				return resp.data;
			});
	}
}
export default new EmployeeService();
