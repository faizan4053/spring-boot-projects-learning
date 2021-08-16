import React from "react";
import 'bootstrap/dist/css/bootstrap.min.css';

import {Button, Row, Col} from 'react-bootstrap';
import 'font-awesome/css/font-awesome.min.css';
// import './AdminProductDetails.css';
const AdminProductDetails=(props)=>{

    return(

        <div className="container-fluid">
			<Row className="justify-content-md-center">
        		<Col md="6">
					<div className="preview-pic tab-content">
					  <div className="tab-pane active" id="pic-1"><img src="http://placekitten.com/400/252" /></div>		  
					</div>
					<div>
						<ul className="preview-thumbnail nav nav-tabs">
						  <li className="active"><a  href="#"><img src="http://placekitten.com/200/126" /></a></li>
						  <li><a  href="#"><img src="http://placekitten.com/200/126" /></a></li>
						  <li><a  href="#"><img src="http://placekitten.com/200/126" /></a></li>
						  <li><a  href="#"><img src="http://placekitten.com/200/126" /></a></li>
						  <li><a  href="#"><img src="http://placekitten.com/200/126" /></a></li>
						</ul>	
					</div>
				</Col>
				<Col md="6">
						<h3 className="product-title">Dell Laptop</h3>
						<div className="rating">
							<div className="stars">
								<span className="rating">Rating: </span>
                                <span className="fa fa-star checked"></span>
								<span className="fa fa-star checked"></span>
								<span className="fa fa-star checked"></span>
								<span className="fa fa-star"></span>
								<span className="fa fa-star"></span>
							</div>
						</div>
                        <p className="description">Description: </p>
						<p className="product-description">Amet mauris commodo quis imperdiet massa tincidunt nunc pulvinar. Sit amet aliquam id diam maecenas ultricies mi eget. Aliquam etiam erat velit scelerisque in dictum. Euismod in pellentesque massa placerat duis ultricies. Volutpat blandit aliquam etiam erat. Augue lacus viverra vitae congue eu.</p>
						<p className="price">Current price: <span>Rs 70000</span></p>
						<p className="quantity">Quantity: <span>50</span></p>
						<p className="pdf">Demo PDF: <span><a href="#">Click here</a></span></p>
						<div className="action">
						     <Button variant="primary" type="submit" type="button">  Edit  </Button>	
						</div>
					</Col>
				</Row>
	</div>
    );

}
export default AdminProductDetails;