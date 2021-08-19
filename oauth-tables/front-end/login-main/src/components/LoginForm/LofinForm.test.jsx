import {shallow  ,configure} from 'enzyme';
import Adapter from '@wojtekmaj/enzyme-adapter-react-17';
import  {render ,screen ,fireEvent} from '@testing-library/react';
import LoginForm from './LoginForm';
[configure({ adapter: new Adapter() })];

describe("testing", () =>{
    test("renders",()=>{
        const wrapper = shallow(<LoginForm />);
        expect(wrapper.exists()).toBe(true);
    });
});