import React, { Component } from 'react';
import EmployeeService from '../EmployeeService';

class EmployeeComponent extends Component {
	constructor(props) {
		super(props);
		this.state = {
			employee: {},
			department: {},
			organization: {},
		};
	}

	componentDidMount() {
		EmployeeService.getEmployee().then((data) => {
			console.log('respone in component', data);
			this.setState({
				employee: data.employee,
				department: data.department,
				organization: data.organization,
			});
		});
	}

	render() {
		return (
			<div>
				<br></br>
				<div className='card col-md-6  offset-md-3'>
					<h3 className='text-center card-header'> View Employee Details </h3>
					<div className='card-body'>
						<div className='row'>
							<p>
								<strong>Employee First Name:</strong>
								{this.state.employee.firstName}
							</p>
						</div>
						<div className='row'>
							<p>
								<strong>Employee Last Name:</strong>
								{this.state.employee.lastName}
							</p>
						</div>
						<div className='row'>
							<p>
								<strong>Employee Email:</strong>
								{this.state.employee.email}
							</p>
						</div>
					</div>
				</div>
			</div>
		);
	}
}

export default EmployeeComponent;
