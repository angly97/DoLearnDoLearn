import React, { useState, useRef, useEffect } from "react";
import SearchIcon from "@mui/icons-material/Search";
import Input from "@mui/joy/Input";
import { SSearchContainer, SWarning } from "./styles";
import axios from "axios";

const SearchBar = ({ setList }) => {
  const SERVER_URL = "http://localhost:8080";
  const [isEmpty, setIsEmpty] = useState(false); // 검색 결과가 있는지 확인

  // 검색 수행
  const doSearch = async () => {
    const keyword = search;
    try {
      const res = await axios.get(`${SERVER_URL}/board/search/${keyword}`);
      setList(res.data.response);
      setIsEmpty(false);
    } catch (err) {
      if (err.response.data.response === "게시물이 없습니다.") {
        setIsEmpty(true);
        setList([]);
      }
    }
  };

  // 검색 input값
  const [search, setSearch] = useState("");

  // 처음 렌더링 되면 검색바에 focus 되도록
  // ======= 작동 안하는거 확인해보기 =======
  const inputRef = useRef();
  useEffect(() => {
    inputRef.current.focus();
  }, []);

  // input에 입력된 값을 search에 저장
  const onChange = (e) => {
    setSearch(e.currentTarget.value);
  };

  // Enter 키를 눌렀을 때의 작업 처리
  const onEnter = (e) => {
    e.preventDefault();
    doSearch();
    setSearch("");
  };

  return (
    <SSearchContainer>
      <form className="search-bar" onSubmit={(e) => onEnter(e)}>
        {/* <input type="text" placeholder="안녕하세요" /> */}
        <Input
          className="input-box"
          ref={inputRef}
          onChange={onChange}
          // onKeyUp={(e) => onEnter(e)}
          value={search}
          placeholder="원하는 강의를 검색하세요"
          aria-label="Search"
          size="sm"
          endDecorator={<SearchIcon />}
        />
      </form>
      {isEmpty ? <SWarning>검색 결과를 찾을 수 없습니다.</SWarning> : ""}
    </SSearchContainer>
  );
};

export default SearchBar;
