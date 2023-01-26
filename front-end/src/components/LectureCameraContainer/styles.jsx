import styled from "styled-components";

export const SContainer = styled.section`
  width: 100%;
  margin: calc(1vw + 8px);
`;

export const SStudentsContainer = styled.div`
  display: flex;
  justify-content: center;
  height: 20%;
  text-align: center; // 나중에 지워야 될 스타일
  div {
    background-color: white;
    width: 20%;
    margin: calc(1vh + 12px) calc(0.5vw + 2px);
    margin-top: 0px;
    border-radius: 12px;
  }
`;

export const SLecturerCameraContainer = styled.div`
  width: 100%;
  height: 70%;
  display: flex;
  justify-content: center;
`;

export const SLecturerCamera = styled.div`
  width: 100%;
  height: 100%;
  background-color: white;
  border-radius: 12px;
  margin: 0px calc(0.5vw + 2px);
`;

export const SOptionContainer = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: #242424;
  text-align: center;
  margin: auto;
  width: 65%;
  margin-top: calc(0.8vw + 2px);
  border-radius: 8px;
  button {
    cursor: pointer;
    display: flex;
    justify-content: space-evenly;
    align-items: center;
    margin: calc(0.5vw + 2px);
    background-color: transparent;
    width: 10%;
    height: 10%;
    border-radius: 8px;
    padding: calc(0.8vw + 2px) calc(1vh + 12px);
    border: none;
    outline: none;
  }
  button:hover {
    background-color: #585858;
    .icon {
      color: ${(props) => props.theme.deeperYellow};
    }
  }
  /* select {
    border: none;
    background-color: transparent;
    outline: none;
  } */
  .icon {
    width: calc(1vw + 12px);
    height: calc(1vh + 12px);
    color: #7e7e7e;
  }
  /* .big-icon {
    width: calc(1vw + 12px);
    height: calc(1vh + 12px);
  } */
  /* .camera-icon {
    transform: translateX(32px);
  }
  .mike-icon {
    transform: translateX(32px);
  } */
  .exit-button:hover {
    background-color: #e53e3e;
    opacity: 1;
    .exit-icon {
      color: white;
    }
  }
`;
