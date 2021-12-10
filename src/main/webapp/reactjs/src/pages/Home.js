import {
    Container,
    Wrapper,
    Content,
    Form,
    Title,
    Label,
    Input,
    Button,
    Text
} from '../components/LoginElements.js';

function Home() {
    return(
    <>
        <Container>
            <Wrapper>
                <Content>
                    <Form>
                        <Title>Home</Title>
                        <Text href="/signin">Sign in</Text>
                        <Text href="/signup">Sign up</Text>
                    </Form>
                </Content>
            </Wrapper>
        </Container>
    </>
    );
}

export default Home