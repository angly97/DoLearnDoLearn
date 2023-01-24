import styled from 'styled-components';
// import Paging from "../Paging";

export const SImg = styled.img`
  display: flex;
  margin: auto;
  width: 10vw;
  aspect-ratio: 1/1;
`;

// UniBoard에 스타일 입히기
export const SUniBoard = styled.div`
  font-family: ${(props) => props.theme.fontFamily};
  border: 1px solid black;
  padding: 5%;
  box-shadow: 0px 0px 3px 0px black;
  border-radius: 5px;
  aspect-ratio: 3/5;
  display: grid;
  place-items: center;
  aspect-ratio: 3/4 solid;
  h4 {
    font-size: ${(props) => props.theme.fontSize.p};
  }
  h3 {
    font-size: ${(props) => props.theme.fontSize.p};
  }
  p {
    font-size: ${(props) => props.theme.fontSize.p};
  }
`;