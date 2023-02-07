import React from "react";
import { useState } from "react";
import RankingItem from "../RankingItem";
import { SRankingSection, SRankingItemContainer } from "./styles";
import Grid from "@mui/material/Grid";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faRankingStar, faTrophy } from "@fortawesome/free-solid-svg-icons";
import { useEffect } from "react";
import { getSortedUserByPoint } from "../../utils/api/userAPI";

const RankingList = () => {
  const [rankingList, setRankingList] = useState([]);
  // 데이터 불러오기
  useEffect(() => {
    getSortedUserByPoint(setRankingList);
  }, []);

  return (
    <SRankingSection>
      <Grid container>
        <Grid item xs={0} md={1.5} />
        <Grid item xs={12} md={9}>
          <h1>
            {/* <FontAwesomeIcon className="ranking-icon" icon={faTrophy} /> */}
            최고의 선생님들(미정)
          </h1>
          <SRankingItemContainer>
            {rankingList.map((item, index) => (
              <RankingItem key={item.id} item={item} index={index} />
            ))}
          </SRankingItemContainer>
        </Grid>
        <Grid item xs={0} md={1.5} />
      </Grid>
    </SRankingSection>
  );
};

export default RankingList;
